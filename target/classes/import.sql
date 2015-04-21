#import.sql file

#Juice Flavors
insert into vaporguide.JuiceFlavor values ( null, 'Beverage');
insert into vaporguide.JuiceFlavor values ( null, 'Candy');
insert into vaporguide.JuiceFlavor values ( null, 'Cereal');
insert into vaporguide.JuiceFlavor values ( null, 'Coffee');
insert into vaporguide.JuiceFlavor values ( null, 'Creamy');
insert into vaporguide.JuiceFlavor values ( null, 'Custard');
insert into vaporguide.JuiceFlavor values ( null, 'Dessert');
insert into vaporguide.JuiceFlavor values ( null, 'Earthy');
insert into vaporguide.JuiceFlavor values ( null, 'Fruity');
insert into vaporguide.JuiceFlavor values ( null, 'Floral');
insert into vaporguide.JuiceFlavor values ( null, 'Minty');
insert into vaporguide.JuiceFlavor values ( null, 'Menthol');
insert into vaporguide.JuiceFlavor values ( null, 'Nutty');
insert into vaporguide.JuiceFlavor values ( null, 'Rich');
insert into vaporguide.JuiceFlavor values ( null, 'Spiced');
insert into vaporguide.JuiceFlavor values ( null, 'Sweet');
insert into vaporguide.JuiceFlavor values ( null, 'Tobacco');
insert into vaporguide.JuiceFlavor values ( null, 'Yogurt');

#Users
insert into vaporguide.User values ( null, 'bmsalm');

#Brand
insert into vaporguide.Brand values ( null, 'Kilo');

#Juice
insert into vaporguide.Juice values ( null, '1', 'Cereal Milk');
insert into vaporguide.Juice values ( null, '1', 'Tru Blue');
insert into vaporguide.Juice values ( null, '1', 'Dewberry Cream');

#Juice Reviews
insert into vaporguide.JuiceReview(id, juice_id, user_id, rating, review, flavor, vapor, throat, worth, vg, pg, nic, steep, flavor_one, flavor_two, flavor_three) values(null, '1', '1', '8', 'My favorite cereal flavor.', '8', '7', '2', '6', '70', '30', '3', '0', '3', '9', '5'); 
insert into vaporguide.JuiceReview(id, juice_id, user_id, rating, review, flavor, vapor, throat, worth, vg, pg, nic, steep, flavor_one, flavor_two, flavor_three) values(null, '2', '1', '7', 'Good - but a little too eggy of a custard.', '7', '7', '2', '5', '70', '30', '3', '1', '6', '16', '5');
insert into vaporguide.JuiceReview(id, juice_id, user_id, rating, review, flavor, vapor, throat, worth, vg, pg, nic, steep, flavor_one, flavor_two, flavor_three) values(null, '2', '1', '9', 'Great flavor - wish it was cheaper though.', '9', '7', '2', '7', '70', '30', '3', '3', '5','16', null);