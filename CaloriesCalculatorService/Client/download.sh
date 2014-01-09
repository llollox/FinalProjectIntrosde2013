#!/bin/bash

rm -rf it/;

wsimport -keep http://localhost:5990/calories/calculator?wsdl;


