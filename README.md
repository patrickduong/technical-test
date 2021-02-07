NOTE: Please note that I am unable to use Google api for this testing since it need to enable the billing address (which need a creditcard and I didn't have it). Therefore, I chose an alternative api which had same mechanism as Google geocoding api (ArcGIS REST JS). However, this api had little features than Google. Please feel free to suggest how to get the new Google api key without needed billing information. 

Please note that this is app for checking reponse api.

#references: 
  1. https://stackoverflow.com/questions/52248646/googlemaps-api-key-for-testing (google map api key limitation)
  2. https://gist.github.com/prof3ssorSt3v3/1a6c030ab8b90dcb71c2eea4cb973c0f (referred code case 2)
  3. https://github.com/googlemaps/js-samples/blob/0b3adf5ff0f42a5982a53b1e0405f08c4f91aa3c/dist/samples/geocoding-simple/index.html (reffered code case 1)
  4. https://developers.arcgis.com/account/billing/ (sign for free tie account and free api key)

#Instruction for testing api case 1 
  1. open file reverse geo coding.html
  2. Enter address/suburb/state/major landmark and hit reverse geo code button (ex:  275-291 Bedford Ave, Brooklyn, New York, 11211, Please DON'T insert comma(s))
  3. It will return the lalitude, longlitude cooridate and address

#Instruction for testing api case 2 
  1. open file reverse geo coding.html
  2. Enter lalitude and longlitude cooridate and hit reverse geo code button (ex: 40.714224,-73.961452, 275-291)
  3. It will return the Address, PostalCode and CountryCode
#Instructions for create automation framework and testing web app AMZ (support Window first)
  1. Download AMZ
  2. Install and setup any requirements, Environment inside README and Pom
  3. Create test Folder Repo_testing and place AMZ and Resources folder at the same level 
