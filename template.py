#PLEASE WRITE THE GITHUB URL BELOW!
#

import sys
import numpy as np
import pandas as pd
import sklearn as sklearn
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.svm import SVC
from sklearn.pipeline import make_pipeline
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import StandardScaler




def load_dataset(dataset_path):
    

    data=pd.read_csv(dataset_path)
    return data
    
def dataset_stat(dataset_df):	
	#To-Do: Implement this function
    dataframe=dataset_df
    num_f=dataframe.shape[1]-1
    num_0=dataframe[dataframe['target']==0]['target'].count()
    num_1=dataframe[dataframe['target']==1]['target'].count()
    return num_f,num_0,num_1
    
def split_dataset(dataset_df, testset_size):
	#To-Do: Implement this function
    data=dataset_df
    X=data.drop(columns="target",axis=1)
    y=data["target"]
           
    xtr,xte,ytr,yte=train_test_split(X,y,test_size=testset_size)
    return xtr,xte,ytr,yte
    
    
def decision_tree_train_test(x_train, x_test, y_train, y_test):
	#To-Do: Implement this function

    dt_pipe=make_pipeline(
        StandardScaler(),
        DecisionTreeClassifier()
    )
    dt_pipe.fit(x_train,y_train)
    
    accuracy=accuracy_score(y_test,dt_pipe.predict(x_test))
    precision=sklearn.metrics.precision_score(y_test,dt_pipe.predict(x_test),average='binary',zero_division='warn')
    recall=sklearn.metrics.recall_score(y_test,dt_pipe.predict(x_test),average='binary',zero_division='warn')
   
    
    return accuracy,precision,recall
    
def random_forest_train_test(x_train, x_test, y_train, y_test):
	#To-Do: Implement this function

    rf_cls=RandomForestClassifier()
    rf_cls.fit(x_train,y_train)
    accuracy=accuracy_score(rf_cls.predict(x_test),y_test)
    precision=sklearn.metrics.precision_score(y_test,rf_cls.predict(x_test),average='binary',zero_division='warn')
    recall=sklearn.metrics.recall_score(y_test,rf_cls.predict(x_test),average='binary',zero_division='warn')
    
    
    return accuracy,precision,recall
def svm_train_test(x_train, x_test, y_train, y_test):
	#To-Do: Implement this function
    svm_pipe=make_pipeline(
        StandardScaler(),
        SVC()
    )
    svm_pipe.fit(x_train,y_train)
    
    accuracy=accuracy_score(y_test,svm_pipe.predict(x_test))
    precision=sklearn.metrics.precision_score(y_test,svm_pipe.predict(x_test),average='binary',zero_division='warn')
    recall=sklearn.metrics.recall_score(y_test,svm_pipe.predict(x_test),average='binary',zero_division='warn')
    
    return accuracy,precision,recall
def print_performances(acc, prec, recall):
	#Do not modify this function!
	print ("Accuracy: ", acc)
	print ("Precision: ", prec)
	print ("Recall: ", recall)

if __name__ == '__main__':
	#Do not modify the main script!
	data_path = sys.argv[1]
	data_df = load_dataset(data_path)

	n_feats, n_class0, n_class1 = dataset_stat(data_df)
	print ("Number of features: ", n_feats)
	print ("Number of class 0 data entries: ", n_class0)
	print ("Number of class 1 data entries: ", n_class1)

	print ("\nSplitting the dataset with the test size of ", float(sys.argv[2]))
	x_train, x_test, y_train, y_test = split_dataset(data_df, float(sys.argv[2]))

	acc, prec, recall = decision_tree_train_test(x_train, x_test, y_train, y_test)
	print ("\nDecision Tree Performances")
	print_performances(acc, prec, recall)

	acc, prec, recall = random_forest_train_test(x_train, x_test, y_train, y_test)
	print ("\nRandom Forest Performances")
	print_performances(acc, prec, recall)

	acc, prec, recall = svm_train_test(x_train, x_test, y_train, y_test)
	print ("\nSVM Performances")
	print_performances(acc, prec, recall)