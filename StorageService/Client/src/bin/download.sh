#!/bin/bash

rm -rf it/;

wsimport -keep http://localhost:5910/lifestyle/storageservice/person?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/healthprofile?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/goal?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activityvaluetype?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activityhistory?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activity?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activityhistoryvalue?wsdl;


