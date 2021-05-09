# NapptilusAndroidChallenge

This app has the goal to list all oompa loompas working in the factory and show their details to make Willy Wonka's HR Department life easier.

Written in Kotlin this apps follows the ViewModel architecture component. The app makes request to a server for retrieveng oompa loompa list and detail information.

The app fully supports view elements visualization for dark mode too.

Makes use of data binding and LiveData to set info into view components. 

For the navigation inside the app, Navigation Component is used. Thanks to the Repository pattern the app can cache the retrieved information keeping it in a Room database and succesfully refresh it when response of the internet is different. 

Coroutines are used for the purpose of excecuting background tasks.

The app has small unit tests written to check correct functiontionality of app behaviours.

## Libraries used

### Retrofit
Library to make request to the server.

### Moshi
Library to easily convert JSON server response into Kotlin data objects.

### Glide
Use for loading images from an URL and configure its display.

### Room
Used for creating database with the cached information.

## App screenchots:

Screen with the Oompa Loompa list:


![Captura de pantalla 2021-05-09 a las 13 25 50](https://user-images.githubusercontent.com/43856037/117570411-460be880-b0ca-11eb-9e39-7cbd5859dbc2.png)


Screen with te Oompa Loompa details:

![Captura de pantalla 2021-05-09 a las 13 25 01](https://user-images.githubusercontent.com/43856037/117570422-4dcb8d00-b0ca-11eb-9f8c-ec557383411c.png)



## Improvements

The app needs a few future improvements such as using Dependency injection for the purpose of doing more suitable tests, add Espresso tests, add Paging library to fully display all oompa loompa information and add DataSource pattern to Repository.

All the technology in the app is used because of the familiarity and knowledge I have with them. I'm aware that other technologies or other approaches may be better but I just want to make the righ impression of my knowledge and work. That's why all kind of comments are welcome.


