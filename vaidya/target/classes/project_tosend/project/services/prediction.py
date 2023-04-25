from numpy import loadtxt
from keras.models import load_model
import pickle 
import pandas as pd
import numpy as np
from sklearn.preprocessing import LabelEncoder
import math
from scipy.stats import mode

def predict(input):
    DATA_PATH = "Training.csv"
    data = pd.read_csv(DATA_PATH).dropna(axis = 1)
    X = data.iloc[:,:-1]
    
    encoder = pickle.load(open('encoder.h5', 'rb'))
    final_svm_model = pickle.load(open('svm.h5', 'rb'))
    final_rf_model = pickle.load(open('rf.h5', 'rb'))
    final_nb_model = pickle.load(open('nb.h5', 'rb'))
    
    symptoms = X.columns.values
    # Creating a symptom index dictionary to encode the
    # # input symptoms into numerical form
    symptom_index = {}
    for index, value in enumerate(symptoms):
        symptom = " ".join([i.capitalize() for i in value.split("_")])
        symptom_index[symptom] = index
    
    data_dict = {
        "symptom_index":symptom_index,
        "predictions_classes":encoder.classes_
    }
    print("This is for checking:"+str(data_dict["symptom_index"]))
    input_data = [0] * len(data_dict["symptom_index"])
    for i in input:
        index = data_dict["symptom_index"][i]
        input_data[index] = 1
         
    # reshaping the input data and converting it
    # into suitable format for model predictions
    input_data = np.array(input_data).reshape(1,-1)
     
    # generating individual outputs
    rf_prediction = data_dict["predictions_classes"][final_rf_model.predict(input_data)[0]]
    nb_prediction = data_dict["predictions_classes"][final_nb_model.predict(input_data)[0]]
    svm_prediction = data_dict["predictions_classes"][final_svm_model.predict(input_data)[0]]
     
    # making final prediction by taking mode of all predictions
    final_prediction = mode([rf_prediction, nb_prediction, svm_prediction])[0][0]
    predictions = {
        "rf_model_prediction": rf_prediction,
        "naive_bayes_prediction": nb_prediction,
        "svm_model_prediction": nb_prediction,
        "final_prediction":final_prediction
    }
    return final_prediction
    

    


