#!/bin/bash

rm -rf it/;

wsimport -keep http://localhost:5910/lifestyle/storageservice/person?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/healthprofile?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/goal?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activitychoosen?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/exercisehistory?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/activity?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/excludedfood?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/favouritefood?wsdl;
wsimport -keep http://localhost:5910/lifestyle/storageservice/exercise?wsdl;


