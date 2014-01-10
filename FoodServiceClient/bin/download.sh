#!/bin/bash

rm -rf it/;

wsimport -keep http://localhost:5920/foodservice/recipes?wsdl;


