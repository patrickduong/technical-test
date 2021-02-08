#Requirement:
1. Install Javadk 1.8.0151
2. Install eclipse
3. Install plug-ins (Pom.xml)
4. Import maven project
5. Check browser version then download the supported browser drivers then place them in AMZ\browserdriver folder
6. Create Invironmental variable for Java 
JAVA_HOME=C:\Program Files\Java\jdk1.8.0_151
7. add path with following value
%JAVA_HOME%\bin,D:\Repo_testing\AMZ\apache-maven-3.3.9\bin

#Execution:
1. Integrated with jenkin (need to add surefireplugin to jenkin). add cli command as below
cd "directory" - default = D:\Repo_testing\AMZ
mvn clean test -Dsurefire.suiteXmlFiles={suiteXmlFile} - default = AMZ_testsuit.xml (need to point path to apache-maven-3.3.9\bin )
2. By default the report will generate right after test is done (allure report)

#Preconditions: 
1. Select platform/browser/url to run (edge/firefox/chrome)
- Default platform is window
- Default browser is chrome
- Default test URL is https://www.amazon.com.au/

#Main actions and webelements:

Step 1: Go to Today’s Deal - Done
	CP: Today's Deal page appears -> wait for control/text appear.(limited 6 seconds)
	option 1: //div[contains(text(),"Deals of the Day run for 24 hours and
	Lightning Deals are available until the deal time expires or when 100% of the
	available stock (including any additional stock we may make available) has
	been claimed. Some products are sold by third party sellers.")]
	
	option 2: //*[@id="nav-subnav"]/a[1]/span[contains(text(),"Today's Deals")] -> choose this

Step 2: Sort the items by “Discount: High to Low” - Done (this text should be - not :
	CP: get value after selected ->
			sub step 1: find ://*[@id="FilterItemView_sortOrder_dropdown"]/div/span[1]/following-sibling::span/span
		click
			sub step 2: select Discount: High to Low
			sub step 3: check selected value is "Discount: High to Low".

Step 3: View Deal for second item. - Done
		Click //*[@id="101_dealView_1"]//descendant::div[@class="a-row stackToBottom"]/div//descendant::span[@class="a-button-inner"]/a[contains(text(),"View Deal")]
	CP: Product-details page display (check with product name)

Step 4: Add 2 items into the cart - Done
			sub step 1: select 2 on //*[@id="quantity"]
			sub step 2: click on //*[@id="add-to-cart-button"]
		CP: congratulation row -> //div[@class="a-box-inner"]//following-sibling::div[1]/div[@id="huc-v2-order-row-messages"]//h1[contains(text(),"Added to Cart")]
Step 5: Go back to main page - Done
		click on logo home //*[@id="nav-logo"]

Step 6: Search for “AAA Batteries” - Done
			sub step 1: enter text AAA Batteries to search field: //*[@id=\"nav-search-bar-form\"]/div[2]/div[@class='nav-search-field']/input"
			sub step 2: select combobox sortby “New and popular”
			sub step 3: click to select a product
		Step 6.1: add 5 items into the cart - Done
		Step 6.2: and tick the check box “Yes I want FREE delivery…” -> not found this one ???? - Blocked
Step 7: shopping cart check (check on UI total 2 items = 7 first) - Done
		Step 7.1: Go to your cart - Done
		sub step 7.1: click to shopping cart or checkout (click on cart button of success added message)
	
postconditions:	
close browser & quit - Done
	
#Remainings :	
1. get qualities of item 1 + price to calculate subtotal by num of quality * price -> check at [stage added successfully]
2. implement function to get index of quality and price within [table] at shopping cart page.

Step 8: Edit the first item quantity - set to 1
	    sub step: get qualities of item 1 + price -> verify quality each item, each item total price, total price (2)
Step 9: Edit the second item quantity – set to 3
		sub step: get qualities of item 1 + price -> verify quality each item, each item total price, total price (3)
Step 10: Delete the first item
		CP: check item 1 not exist
		CP: get qualities of item 2 + price -> verify quality each item, each item total price, total price (4)
Step 11: Click “Proceed to Checkout”
		CP: check final page (sigin page)

postconditions:
Clear all product (delete) - not implemented yet
