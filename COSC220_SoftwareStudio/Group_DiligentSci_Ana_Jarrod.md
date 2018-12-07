## Group Diligent Sci

### Team

- Jarrod Baker (jbaker46@myune.edu.au)
- Ana Vintila (avintila@myune.edu.au)

### Issue

- Item trading system (Issue #23)

### Main classes and tests

##### Ana Vintila:
Trade
├── main
│   ├── java
│   │   └── rewind
│   │       └── trade
│   │           ├── duplicateOrderException.java
|   |           ├── ExactOrderPriceMatchingStrategy.java
│   │           ├── Order.java
│   │           ├── OrderManagerService.java
│   │           ├── OrderMatch.java
│   │           ├── OrderMatchingStrategy.java
│   │           ├── orderNotFoundException.java
│   │           ├── OrderStatus.java
│   │           ├── OrderType.java
│   │           ├── salesAgent.java (implemented by another team, not by diligent-sci)
│   │           ├── TradeStrategy.java
│   │           └── Transaction.java
└── test
    └── java
        └── rewind
            └── trade
                ├── ExactOrderPriceMatchingStrategyTests.java
                ├── OrderManagerServiceTest.java
                ├── OrderMatchTest.java
                ├── OrderTest.java
                ├── ScenarioHelper.java
                └── TransactionTest.java

##### Jarrod: 
client
    ├── Audio
    ├── jfx
    │   ├── Main.java
    │   ├── TradeController.java
    │   ├── UI.java
    ├── Keyboard.java
    └── Trade
        ├── buyCellItem.java
        ├── sellCellItem.java
        ├── sellSelectCellItem.java
        ├── tradeScreen.java
        ├── view_buy.java
        ├── view_home.java
        └── view_sell.java

### Difficulties

##### Jarrod:
- The introduction of the Keyboard class temporarily broke our features as it was no longer accessible due a listener eating all of the keyboard events. This was difficult to resolve due to the layout of the packages in the the project and Gradle's circular dependency requirements. It required some pretty major refactoring to ensure that the TradeController had the references he needed to the player/world to update the client side properly.
- Currency was implemented through the Catalogue, including the catalogue.json file. The json file proved to be pretty fragile, and adding fields required updating all objects without the file. Whenever other teams changed something it often broke.

##### Ana: 
- Had to use a regular for-loop for iterating over Orders in the exact price strategy matcher algorithm class because using a stream() did not work for some reason. Have not figured out how to use a stream to iterate over the Orders so just kept the for loop. 
- At the very beginning of the trimester, the gradle project was not seeing my trade module so I had to write “include(“trade”)” in the settings.gradle file. After that, the gradle could see my project and everything under the trade module could compile. 
- What is not working: In the ExactOrderPriceMatcherStrategyTest, the output returned from the single test is this: 
13:35:35.605 [main] DEBUG rewind.core.Catalogue - (Item Name) Item not found: 
13:35:35.621 [main] DEBUG rewind.core.Catalogue - (Item Name) Item not found: 
(etc)
13:35:35.836 [main] INFO rewind.core.Catalogue - Item catalogue imported successfully
13:35:35.856 [main] INFO rewind.core.Catalogue - Recipe catalogue imported successfully
I am not sure why the debug statements are returned but the algorithm does still seem to work because the tradeable list contains the same OrderMatches as the testMatches list. 


### Team contributions

- Jarrod
	- Mainly GUI and client side
	- Contributed to backend work
- Ana: 
Worked only on the back-end code for creating Orders, the Singleton OrderManagerService class, the OrderMatch, enums for describing Orders (OrderStatus and OrderType), Transaction, and the algorithm interface and implementing class for matching orders, and also the class and sequence diagrams for design patterns that have been and could be used in the code.


From `git-quick-stats`

##### Jarrod: 
	 jbaker46 <jbaker46@myune.une.edu.au>:
	  insertions:    311 (0%)
	  deletions:     64 (0%)
	  files:         28 (1%)
	  commits:       8 (1%)
	  lines changed: 375
	  first commit:  Sun Aug 26 10:25:15 2018 +0200
	  last commit:   Sun Aug 26 17:35:54 2018 +0200

	 Jarrod Baker <jbaker46@myune.edu.au>:
	  insertions:    885 (1%)
	  deletions:     307 (1%)
	  files:         45 (1%)
	  commits:       19 (2%)
	  lines changed: 1192
	  first commit:  Sat Jul 28 18:59:45 2018 +0200
	  last commit:   Wed Sep 26 19:41:56 2018 +0200

##### Ana: 

Ana Vintila <avintila@myune.edu.au>:
      insertions:    1728 (2%)
      deletions:     947 (2%)
      files:         119 (3%)
      commits:       39 (3%)
      lines changed: 2675
      first commit:  Fri Aug 3 02:43:46 2018 -0400
      last commit:   Thu Oct 4 15:43:18 2018 -0400

BabitzdaBrave <amg.vintila@gmail.com>:
      insertions:    50 (0%)
      deletions:     2 (0%)
      files:         4 (0%)
      commits:       2 (0%)
      lines changed: 52
      first commit:  Fri Aug 3 02:32:38 2018 -0400
      last commit:   Fri Aug 3 06:39:45 2018 -0400


### Main Work and Classes: 

##### Ana: 

trade/build.gradle
trade/src/main/java/rewind/trade/duplicateOrderException.java
trade/src/main/java/rewind/trade/ExactOrderPriceMatchingStrategy.java
trade/src/main/java/rewind/trade/Order.java
trade/src/main/java/rewind/trade/OrderManagerService.java
trade/src/main/java/rewind/trade/OrderMatchingStrategy.java
trade/src/main/java/rewind/trade/OrderMatch.java
trade/src/main/java/rewind/trade/orderNotFoundException.java
trade/src/main/java/rewind/trade/OrderStatus.java
trade/src/main/java/rewind/trade/OrderType.java
trade/src/main/java/rewind/trade/Service.java
trade/src/main/java/rewind/trade/Transaction.java
trade/src/main/resources/factoryClass.puml
trade/src/main/resources/factorySequence.puml
trade/src/main/resources/OverallClass_Intellij_Generated.png
trade/src/main/resources/OverallClass.puml
trade/src/main/resources/OverallSequenceWorkflow.puml
trade/src/main/resources/singletonClass.puml
trade/src/main/resources/singletonSequence.puml
trade/src/main/resources/strategyClass.puml
trade/src/main/resources/strategySequence.puml
trade/src/main/resources/visitorClass.puml
trade/src/main/resources/visitorSequence.puml
trade/src/Order.java

###### Ana: List of Tests Created: (all the tests in these files below)
trade/src/test/java/rewind/trade/ExactOrderPriceMatcherStrategyTest.java
trade/src/test/java/rewind/trade/OrderManagerServiceTest.java
trade/src/test/java/rewind/trade/OrderMatchTest.java
trade/src/test/java/rewind/trade/OrderTest.java
trade/src/test/java/rewind/trade/ScenarioHelper.java
trade/src/test/java/rewind/trade/TransactionTest.java


##### Jarrod: 

build.gradle
client/build.gradle
client/src/main/java/rewind/client/jfx/TradeController.java
client/src/main/java/rewind/client/jfx/UI.java
client/src/main/java/rewind/client/Keyboard.java
client/src/main/java/rewind/client/Trade/buyCellItem.java
client/src/main/java/rewind/client/Trade/cell_item.java
client/src/main/java/rewind/client/Trade/sellCellItem.java
client/src/main/java/rewind/client/Trade/sellSelectCellItem.java
client/src/main/java/rewind/client/Trade/tradeCSS.css
client/src/main/java/rewind/client/Trade/tradeScreen.java
client/src/main/java/rewind/client/Trade/view_buy.java
client/src/main/java/rewind/client/Trade/view_home.java
client/src/main/java/rewind/client/Trade/view_sell.java
client/src/main/resources/assets/css/tradeCSS.css
client/src/main/resources/assets/data/catalogue.json
client/src/test/java/rewind/client/TradeContollerTest.java
core/src/main/java/rewind/core/Catalogue.java
core/src/main/java/rewind/core/Inventory.java
core/src/main/java/rewind/core/ItemInfo.java
core/src/main/java/rewind/core/Item.java
core/src/main/java/rewind/core/items/GenericItem.java
core/src/main/java/rewind/core/items/Tradeable.java
core/src/main/java/rewind/core/npc/quests/Quest_Jump_3_Times.java
core/src/main/java/rewind/core/npc/Tradeable.java
core/src/main/java/rewind/core/Player.java
core/src/test/java/rewind/core/CatalogueTest.java
core/src/test/java/rewind/core/GenericItemTest.java
core/src/test/java/rewind/core/InventoryTest.java
trade/src/main/java/rewind/trade/Order.java
trade/src/main/java/rewind/trade/OrderManagerService.java
trade/src/main/java/rewind/trade/OrderStatus.java
trade/src/main/java/rewind/trade/salesAgent.java
trade/src/main/java/rewind/trade/Service.java
trade/src/main/java/rewind/trade/TradeStrategy.java
trade/src/main/resources/BuySell_sequence.puml
trade/src/test/java/rewind/trade/ScenarioHelper.java

### Notes

- As far as we can tell, we were a team of two. 

### Videos
First Progress Video: https://youtu.be/sVrj5XvlqWA  
Final Group Demo video: https://youtu.be/pml_K19EpFM 

