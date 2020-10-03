# kotlin-android-calculator
I created a simple Calculator, written in Kotlin, using Model-View-Presenter approach and seperate class for Math Operations. App can be downloaded from Google Play Store here: https://play.google.com/store/apps/details?id=com.howmehow.android.calculator.
All the functions work correctly. I've used Kotlin Long numbers for retrieving results, it's roughly giving 18-19 digits to work with, but user can only input in single number 14 digits, when there are decimals, I've used BigDecimals that give quite a lot of flexibility, but for this app I limited it to 10 numbers after point, and rounded half_up. Also I managed to cut down trailing zeros in decimals which was quite a challenge.
Full design is created in Constraint Layout, which is amazingly behaving in the majority of the smartphones. App is not optimised for other devices (like tablets, or watches). Maybe in the future. Also I blocked the possibility to use it in landscape mode, as that was not in my focus for the time being. 

Main activity is focusing only on responding to events that are happening because of the user, the Presenter is having all those responses and making the logic of the app, using MathematicalOperations for operations. In the Contract you can find functions that can be used across the View and Presenter (kind of a bridge in between). 
I wrote all the functions myself except sqrt(). With bigger screens like tablets I decided to keep it compact. 

Generally app was created for educational reasons, and to show my skills. I had help from a Senior Developer to point me issues, and where to tidy the code, but the app was written by me. 

<img src="https://user-images.githubusercontent.com/58289892/94999553-556a0700-05ba-11eb-844b-dd8f1200bc7f.gif" width="360" height="640" />

<img src="https://user-images.githubusercontent.com/58289892/94999555-5ac75180-05ba-11eb-93ff-e60af1769a36.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999556-5b5fe800-05ba-11eb-9adf-89af04de5aad.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999557-5b5fe800-05ba-11eb-9c95-a3afb1bcb73c.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999558-5b5fe800-05ba-11eb-8513-88630cbf5640.png" width="180" height="320" />



