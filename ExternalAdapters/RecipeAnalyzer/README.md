##Recipe Analyzer
This is an adapter that take as input a recipe as a json and provide some informations like calories calling Edamam api's .

[API Documentation PAGE](https://developer.edamam.com/docs).

####Interact with API

app_id = <b>0391102e</b>

app_key = <b>49b4d54afcee8097e23228be928a81d1</b>

Set Header Content-Type: <b>application/json</b>

**POST REQUEST https://api.edamam.com/api/nutrient-info?extractOnly=&app_id=0391102e&app_key=49b4d54afcee8097e23228be928a81d1**



#####Body Request Example:
```json
{
  "title": "Fresh Ham Roasted With Rye Bread and Dried Fruit Stuffing",
"prep": "1. Have your butcher bone and butterfly the ham and score the fat in a diamond pattern. ...",
"yield": "About 1 servings",
"ingr": [    
    "7 cloves garlic, minced",
 	"1 cup chopped onions",
    "2 cloves garlic, minced",
    "5 cups beef stock",
    "1/3 cup water",
    "1/2 cup red wine",
    "4 tomatoes - peeled, seeded and chopped",
    "1 cup chopped carrots",
    "1/2 teaspoon dried basil",
    "1/2 teaspoon dried oregano",
    "1 cup tomato sauce",
    "1 zucchini, chopped",
    "8 ounces cheese tortellini",
    "1 green bell pepper, chopped",
    "1 tablespoon chopped fresh parsley",
    "2 tablespoons grated Parmesan cheese for topping"
  ]
}
```

#####Response Example:
{
    "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_7bd20988658d2e37a8f12728bfdf2a4f",
    
    "yield": 1,
    
    "calories": 1417,
    
    "dietLabels": [
    
        "HIGH_FIBER"
    
    ],
    
    "healthLabels": [
    
        "EGG_FREE",
    
        "PEANUT_FREE",
    
        "TREE_NUT_FREE",
    
        "SOY_FREE",
    
        "FISH_FREE",
    
        "SHELLFISH_FREE"
    
    ],
    
    "cautions": [],
    
    "totalNutrients": {
    
        "ENERC_KCAL": {
    
            "label": "Energy",
    
            "quantity": 1417.563536,
    
            "unit": "kcal"
    
        }
    
    },
    
    "totalDaily": {
    
        "ENERC_KCAL": {
    
            "label": "Energy",
    
            "quantity": 70.8781768,
    
            "unit": "%"
    
        }
    
    }
}
