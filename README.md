# kotlin-android-calculator
I created a simple Calculator, written in Kotlin, using Model-View-Presenter approach and seperate class for Math Operations. App can be downloaded from Google Play Store here: https://play.google.com/store/apps/details?id=com.howmehow.android.calculator.
All the functions work correctly. I've used Kotlin Long numbers for retrieving results, it's roughly giving 18-19 digits to work with, but user can only input in single number 14 digits, when there are decimals, I've used BigDecimals that give quite a lot of flexibility, but for this app I limited it to 10 numbers after point, and rounded half_up. Also I managed to cut down trailing zeros in decimals which was quite a challenge.
The second TextView is behaving like a history collector, so user can see all the numbers and operations until they not gonna press AC.
Full design is created in Constraint Layout, which is amazingly behaving in the majority of the smartphones and tablets. 

Main activity is focusing only on responding to events that are happening because of the user, the Presenter is having all those responses and making the logic of the app, using MathematicalOperations for operations. In the Contract you can find functions that can be used across the View and Presenter (kind of a bridge in between). 
I wrote all the functions myself except sqrt(). 

Generally app was created for educational reasons, and to show my skills. I had help from a Senior Developer to point me issues, and where to tidy the code, but the app was written by me. 

<img src="https://user-images.githubusercontent.com/58289892/94999868-b561ad00-05bc-11eb-913c-a88267e85ca4.gif" width="360" height="640" />

<img src="https://user-images.githubusercontent.com/58289892/94999869-b692da00-05bc-11eb-9aeb-da850980594b.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999870-b692da00-05bc-11eb-878b-4118ef8b3829.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999871-b72b7080-05bc-11eb-9aa2-c66912d59e57.png" width="180" height="320" /> <img src="https://user-images.githubusercontent.com/58289892/94999873-b72b7080-05bc-11eb-97f5-0c2558ba6aa4.png" width="180" height="320" />

