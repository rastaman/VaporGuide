## Credera DJ Jukebox

### My Assumptions
- Jaz-E Jen will need to be the only one to login. Anyone can access the app and request a song, with no limit on requests.
- Users will not enter songs at a extremely fast rate (i.e. DOS)
- No one will be using this app in an unintended way, i.e. manually typing in URLS, trying to "hack" Jaz-E Jenn's Catalog
- The users are using a compatible device/browser 
- The Jaz-E Jenn will only enter query safe characters into fields
- A song can be added to the queue more than once
- While it could be wise to use a Thread Safe singleton or something to that effect for the queue, 
	we will persist the queue to the database just in case the program crashes - and Jenn can recover the queue.
- Jaz-e trusts that the app works and doesn't require any junit tests


### Project Details
Our client, DJ Jaz-e Jenn, has engaged us to build a browser based song request interface. During weddings and raves, Jaz-e
frequently becomes distracted by patrons requesting their favorite Michael Bolton song. Frankly, Jaz-e celebrates the guy's
entire catalog, but that's a story for another day.

### Catalog Maintenance
Jaz-e needs to be able to enter the names of the artists, albums and songs in her catalog. She should be able to add an artist.
Once the artist is entered, albums can be added to the artists. After entering the album, songs can be added to the album. Finally,
Jaz-e would like to be able to edit and delete elements within her catalog.

### Requesting Songs
Party patrons need to be able to request songs in the catalog. As patrons request a song, it needs to be added to a queue for
Jaz-e to work off.

### Working Off the Queue
As Jaz-e plays a song, she needs to able to remove requests from her queue.

### Security
- Only Jaz-e can add, edit and delete elements from the catalog.
- Party patrons and Jaz-e can add songs to the request queue.
- Only Jaz-e can remove songs from the queue

### Interface
Jaz-e says she just wants the interface to be usable. She is not concerned with how pretty the interface looks. She wants a menu 
bar at the top that includes the ability for her to log in. Users should be able to navigate from artists to albums to browse and 
select songs to add to the queue.

### Instructions
You have been tasked with building the interface described above. The basic structure of your project is already built. Expand
upon the given project to build this interface. Here are a few suggestions from the architect on your project.

- Use Spring MVC
- Persist data in the provided HSQLDB
- Use the provided Spring Security role definitions
- Create the interface any way you would like, but I've heard good things about Twitter Bootstrap

You should be able to walk a reviewer through your code. You are encouraged to make assumptions as necessary. Document your assumptions.

