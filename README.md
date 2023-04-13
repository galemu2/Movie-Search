# Movie Search
## API key setup
Api Key was obtained from [The Movie DB](https://www.themoviedb.org/documentation/api)
1. add `gradle.properties` into `.gitignore` file
2. Place the api key in `gradle.properties` file
```
    API_KEY="your api key"
```
3. Add following line in app level `build.gradle` file,
```gradle
android {
    ...
    defaultConfig {
    ...
        buildConfigField("String", "API_KEY", API_KEY)
    }
}
```
4. Use API key within code using BuildConfig
```
    val API_KEY :String = BuildConfig.API_KEY
 ```
