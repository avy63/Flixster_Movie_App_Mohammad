# Project 2 - *Mohammad Wahiduzzaman Khan*

**Flixster** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **10** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API
* [x] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [x] For each movie displayed, user can see the following details:
  * [x] Title, Poster Image, Overview (Portrait mode)
  * [x] Title, Backdrop Image, Overview (Landscape mode)
* [x] Allow user to view details of the movie including ratings within a separate activity

The following **stretch** features are implemented:

* [x] Improved the user interface by experimenting with styling and coloring.
* [x] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [x] Apply the popular [View Binding annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-ViewBinding) to reduce boilerplate code.
* [x] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [x] Action bar changes when looking at movie details
* [x] Movie details includes numerical rating next to the rating bar

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='video/Flixter.gif' title='Video Walkthrough' width='600' alt='Video Walkthrough' />

GIF created with [Online Converter](https://www.onlineconverter.com/video-to-gif).

## Screenshot Walkthrough

Here's a Screenshot of implemented user stories:

<img src='images/1.jpg' title='First' width='600' alt='Video Walkthrough' />
<img src='images/2.jpg' title='Second' width='600' alt='Video Walkthrough' />
<img src='images/3.jpg' title='Third' width='600' alt='Video Walkthrough' />
<img src='images/4.jpg' title='Fourth' width='600' alt='Video Walkthrough' />
## Notes:

Issues faced:
* Gradle sync
* Both okhttp3 and glide has Headers class, make sure you import the correct one


## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2022] [Mohammad Wahiduzzaman Khan]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
