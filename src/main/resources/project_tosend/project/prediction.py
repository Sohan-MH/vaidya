from numpy import loadtxt
from keras.models import load_model
import numpy as np

def make_predictions(img):
	model = load_model('vaidya.sav')
	y = model.predict(img)
	y = np.argmax(y)
	return y