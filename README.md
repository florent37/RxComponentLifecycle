# RxComponentLifecycle

Rx binding of new Android Architecture Component Lifecycle

[ ![Download](https://api.bintray.com/packages/florent37/maven/rxcomponent-lifecycle/images/download.svg) ](https://bintray.com/florent37/maven/rxcomponent-lifecycle/_latestVersion)

```java
def arch_version = "1.0.0-alpha1"

dependencies {
    compile 'com.github.florent37:rxcomponent-lifecycle:1.0.0'

    annotationProcessor "android.arch.lifecycle:compiler:$arch_version"
    compile "android.arch.lifecycle:runtime:$arch_version"
    compile "android.arch.lifecycle:extensions:$arch_version"
    
    compile 'io.reactivex.rxjava2:rxjava:2.1.0'
}
```

Don't forget to add google's maven

```java
allprojects {
    repositories {
        jcenter()
        maven { url 'https://maven.google.com' }
    }
}
```

# Usage

```java
RxLifecycle.with(getLifecycle())

           .onDestroy() //receive all events
           
           .subscribe(event -> //do what you had to do on view destroy);
```

# Events

```java
RxLifecycle.with(getLifecycle())

           .onCreate() 
           .onStart() 
           .onResume() 
           
           .onPause() 
           .onStop() 
           .onDestroy()
            
           .onEvent() //all events
           
           .subscribe(event -> //do what you had to do on view destroy);
````

# Credits

Author: Florent Champigny [http://www.florentchampigny.com/](http://www.florentchampigny.com/)

Blog : [http://www.tutos-android-france.com/](http://www.www.tutos-android-france.com/)

<a href="https://plus.google.com/+florentchampigny">
  <img alt="Follow me on Google+"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/gplus.png" />
</a>
<a href="https://twitter.com/florent_champ">
  <img alt="Follow me on Twitter"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/twitter.png" />
</a>
<a href="https://www.linkedin.com/in/florentchampigny">
  <img alt="Follow me on LinkedIn"
       src="https://raw.githubusercontent.com/florent37/DaVinci/master/mobile/src/main/res/drawable-hdpi/linkedin.png" />
</a>


License
--------

    Copyright 2017 Florent37, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
