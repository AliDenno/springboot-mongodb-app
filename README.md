# SpringBoot & MongoDB

* DbSeeder is used to prepopulate the database
* QueryDSL is used to write queries that are type safe (no more magic or strange strings)
* **@TextIndexed** annotation is used to help in full text search
* **@DbRef** annotation is used to create a document reference
* **Flapdoodle** is used as a in memory mongodb server that can be used for tests 
* Use [mongobee](https://github.com/mongobee/mongobee) for DB migration and management
* The Data model used:

![image](https://user-images.githubusercontent.com/6619191/72564798-deb49e80-38b0-11ea-9bd7-2f0261e6b42d.png)

