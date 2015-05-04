#import.sql file

#Juice Flavors
insert into vaporguide.JuiceFlavor(name) values ('Beverage');
insert into vaporguide.JuiceFlavor(name) values ('Candy');
insert into vaporguide.JuiceFlavor(name) values ('Cereal');
insert into vaporguide.JuiceFlavor(name) values ('Coffee');
insert into vaporguide.JuiceFlavor(name) values ('Creamy');
insert into vaporguide.JuiceFlavor(name) values ('Custard');
insert into vaporguide.JuiceFlavor(name) values ('Dessert');
insert into vaporguide.JuiceFlavor(name) values ('Earthy');
insert into vaporguide.JuiceFlavor(name) values ('Fruity');
insert into vaporguide.JuiceFlavor(name) values ('Floral');
insert into vaporguide.JuiceFlavor(name) values ('Minty');
insert into vaporguide.JuiceFlavor(name) values ('Menthol');
insert into vaporguide.JuiceFlavor(name) values ('Nutty');
insert into vaporguide.JuiceFlavor(name) values ('Rich');
insert into vaporguide.JuiceFlavor(name) values ('Spiced');
insert into vaporguide.JuiceFlavor(name) values ('Sweet');
insert into vaporguide.JuiceFlavor(name) values ('Tobacco');
insert into vaporguide.JuiceFlavor(name) values ('Yogurt');

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
insert into vaporguide.JuiceReview(id, juice_id, user_id, rating, review, flavor, vapor, throat, worth, vg, pg, nic, steep, flavor_one, flavor_two, flavor_three) values(null, '2', '1', '9', 'Great flavor - wish it was cheaper though.', '9', '7', '2', '7', '70', '30', '3', '3', '5','16', '');