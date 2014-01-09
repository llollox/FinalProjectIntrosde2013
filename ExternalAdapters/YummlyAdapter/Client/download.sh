#!/bin/bash

rm -rf it/;

wsimport -keep http://localhost:5920/food/readrecipes?wsdl;


