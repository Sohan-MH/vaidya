from services import prediction
import pickle as pickle
from flask import Flask,render_template,request,session,redirect,url_for,jsonify
from flask_mysqldb import MySQL
import yaml
app = Flask(__name__)
app.secret_key = "super secret key"
db = yaml.safe_load(open('db.yaml'))
app.config['MYSQL_HOST'] = db['mysql_host']
app.config['MYSQL_USER'] = db['mysql_user']
app.config['MYSQL_PASSWORD'] = db['mysql_password']
app.config['MYSQL_DB'] = db['mysql_db']

mysql = MySQL(app)

@app.route('/')
def index():
    
    return render_template('index.html')

@app.route('/diag')
def diag():
    return render_template('patient_login.html')

@app.route('/home_p')
def home():
    return render_template('pat_postlogin.html')

@app.route('/cont')
def contact():
    return render_template('contact.html')

@app.route('/pt')
def pateint_reg():
    return render_template('patient_login.html')

@app.route('/pl_s',methods= ['POST'])
def pl_s():
    msg = ''
    details = request.form
    username = details['username']
    password = details['password']
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM user_details WHERE username = %s AND passsword = %s",(username,password))
    record = cur.fetchone()
    if record:
        cur.close()
        session['loggedin'] = True
        session['username'] = record[1]
        return render_template('pat_postlogin.html',username = session['username'],msg = msg)
    else:
        msg = 'Incorrect username/password.Try again!'
    cur.close()
    return render_template('patient_login.html',msg = msg)

@app.route('/diag_post',methods= ['POST'])
def diag_post():
    return render_template('diagnosis.html', username = session['username'])

@app.route('/dl_s',methods= ['POST'])
def dl_s():
    msg = ''
    details = request.form
    username = details['Uname']
    password = details['Pass']
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM doctor_details WHERE UserName = %s AND Doc_Password = %s",(username,password))
    record = cur.fetchone()
    if record:
        session['loggedin'] = True
        session['username'] = record[1]
        cur.close()
        return render_template('pat_postdoc_login.html',msg = msg,username = session['username'])
    else:
        msg = 'Incorrect username/password.Try again!'
    cur.close()
    return render_template('doctor_login.html',msg = msg)

@app.route('/d_r')
def doctor_reg():
    return render_template('doctor_login.html')

@app.route('/doc_reg')
def doctor_log():
    return render_template('doctor_reg.html')

@app.route('/dr_reg_suc',methods = ['POST'])
def doctor_reg_suc():
    details = request.form
    name = details['name']
    username = details['username']
    reg_num = details['reg_num']
    age = details['age']
    email = details['email']
    password = details['password']
    phno = details['phno']
    resume = details['resume']
    gender1=request.form.getlist("gender")
    cur = mysql.connection.cursor()
    cur.execute("INSERT INTO doctor_details(Full_Name,UserName,Government_Registration_Number,Age,Email,Phone_Number,Doc_Password,Doc_Resume) VALUES(%s,%s,%s,%s,%s,%s,%s,%s)",(name,username,reg_num,age,email,phno,password,resume))
    mysql.connection.commit()
    cur.close()
    return render_template('index.html')
    

@app.route('/pat_reg')
def pat_reg():
    return render_template('patient_reg.html')

@app.route('/logout')
def logout():
    session.pop('loggedin',None)
    session.pop('username',None)
    # return render_template('patient_reg.html')  
    return render_template('index.html')    


@app.route('/p_s',methods = ['POST'])
def patient_login():
    details = request.form
    gender1=request.form.getlist("gender")
    age = details['age']
    email = details['email']
    fullname = details['fullname']
    # gender = details['gender']
    gender = gender1
    password = details['password']
    phno = details['phone_num']
    username = details['username']
    cur = mysql.connection.cursor()
    msg = 'Successfully registered'
    cur.execute("INSERT INTO user_details(age,email,fullname,gender,passsword,phone_num,username) VALUES(%s,%s,%s,%s,%s,%s,%s)",(age,email,fullname,gender,password,phno,username))
    mysql.connection.commit()
    cur.close()
    return render_template('index.html',msg=msg)


@app.route('/diagnose_disease',methods = ['POST'])
def diagnose_disease():
    details = request.form
    cur = mysql.connection.cursor()
    value = prediction.predict(details.getlist('symptoms'))
    #print("Username"+session['username'])
    ans = ''
    for i in details.getlist('symptoms'):
        ans = ans + i
    
    cur.execute("INSERT INTO Doc_report(username,symptoms,predictions) VALUES(%s,%s,%s)",([session['username']],ans,value)) 
    mysql.connection.commit()
    cur.close()
    return render_template('pred_result.html',value = value)


@app.route('/doc_sug',methods = ['POST'])
def doctor_sug():
    cur = mysql.connection.cursor()
    cur.execute("select * from Doc_report where username = %s",[session['username']])   
    records = cur.fetchall()
    cur.close()
    return render_template("doctor_suggestion.html",data=records)

@app.route('/doc_give_sug',methods = ['POST'])
def give_doc_suggestions():
    cur = mysql.connection.cursor()
    cur.execute("select* from Doc_report")
    records=cur.fetchall()
    cur.close()
    return render_template('doc_give_sug.html',data=records,username = session['username'])

@app.route('/send_sug',methods = ['POST'])
def doc_suggestions_accept():
    details=request.form
    cur = mysql.connection.cursor()
    # msg="THANK YOU!!! YOUR SUGGESTION IS UPDATED"
    username=details['Uname']
    suggestions=details["suggestions"]
    cur.execute("select * from Doc_report where username=%s",[username])
    check=cur.fetchall()
    if(check):
        cur.execute("update Doc_report set doctor_suggestions=%s where username=%s ",(suggestions,username))
        mysql.connection.commit()
        msg="THANK YOU!!! YOUR SUGGESTION IS UPDATED"
    else:
        msg='PLEASE ENTER VALID USER NAME'
    cur.execute("select* from Doc_report")
    records=cur.fetchall()
    cur.close()
    return render_template('doc_give_sug.html',msg=msg,data=records)
    
    
@app.route('/predict',methods = ['POST'])
def predict_for_java():
    details = request.get_json()['symptoms']
    value = prediction.predict(details)
    #print("Username"+session['username'])
    ans = ''
    for i in details:
        ans = ans + i
    print(request.get_data);
    vd = {"disease": value};
    
    return jsonify(value);


if __name__ == "__main__":
    app.run(debug=True)