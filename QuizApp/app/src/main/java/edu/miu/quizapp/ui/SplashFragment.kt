package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 1000)
    }

    fun addQuestionsToDB(){
        val quiz1 = Quiz(1L,"1) Is it possible to have an activity without UI to perform action/actions?","A. Not possible", "B. Wrong question","C. Yes, it is possible","D. None of the above","c","Answer: (c) Yes, it is possible\n" +
                "\n" +
                "Explanation: Generally, every activity is having its UI(Layout). But if a developer wants to create an activity without UI, he can do it.")
        val quiz2 = Quiz(2L,"2) How many sizes are supported by Android?", "A. Android supported all sizes","B. Android does not support all sizes","C. Android supports small,normal, large and extra-large sizes","D. Size is undefined in android","c","Answer: (c) Android supports small,normal, large and extra-large sizes\n" +
                "\n" +
                "Explanation: X-large screens are having at least 960dp*720dp resolutions\n" +
                "\n" +
                "Large screens are having at least 640dp*480dp resolutions\n" +
                "\n" +
                "Normal screens are having at least 470dp*320dp resolutions\n" +
                "\n" +
                "Small screens are having at least 426dp*320dp resolutions")
        val quiz3 = Quiz(3L,"3) How to stop the services in android?","A. finish()", "B. system.exit().","C. By manually","D. stopSelf() and stopService()","d","Answer: (d) stopSelf() and stopService()\n" +
                "\n" +
                "Explanation: We can stop the services by stopSelf() and stopService(), in some cases android will kill the services due to the low memory problem.")
        val quiz4 = Quiz(4L,"4) How to store heavy structured data in android?","A. Shared Preferences", "B. Cursor","C. SQlite database","D. Not possible","c","Answer: (c) SQlite database\n" +
                "\n" +
                "Explanation: We can store structured data in SQlite database only. SQlite database is very efficient and faster to read and store the data.")
        val quiz5 = Quiz(5L,"5) What is the application class in android?","A. A class that can create only an object", "B. Anonymous class","C. Java class","D. Base class for all classes","d","Answer: (d) Base class for all classes\n" +
                "\n" +
                "Explanation: Application class is the base class for any android application.")
        val quiz6 = Quiz(6L,"6) What is APK in android?","A. Android packages", "B. Android pack","C. Android packaging kit","D. None of the above","c","Answer: (c) Android packaging kit\n" +
                "\n" +
                "Explanation: APK is an android packaging kit. We can pack/zip, our code in apk format to work on Android devices as an application.")
        val quiz7 = Quiz(7L,"7) What is the library of Map View in android?","A. com.map", "B. com.goggle.gogglemaps","C. in.maps","D. com.goggle.android.maps","d","Answer: (d) com.goggle.android.maps\n" +
                "\n" +
                "Explanation: com.google.android.maps is the library of the map view in android. We can access google maps by calling this library.")
        val quiz8 = Quiz(8L,"8) What is a GCM in android?","A. Goggle Could Messaging for chrome", "B. Goggle Count Messaging","C. Goggle Message pack","D. None of the above","a","Answer: (a) Goggle Could Messaging for chrome\n" +
                "\n" +
                "Explanation: Using with google could messaging, we can push the data from the servers to client devices. In short, we can send messages to mobile devices through the cloud(Push Notification).")
        val quiz9 = Quiz(9L,"9) Is it possible activity without UI in android?","A. No, it's not possible", "B. Yes,it's possible","C. We can't say","D. None of the above","b","Answer: (b) Yes,it's possible\n" +
                "\n" +
                "Explanation: Without UI, we can call an activity, It will do some background functionalities.")
        val quiz10 = Quiz(10L,"10) What is a thread in android?","A. Same as services", "B. Background activity","C. Broadcast Receiver","D. Independent dis-patchable unit is called a thread","d","Answer: (d) Independent dis-patchable unit is called a thread\n" +
                "\n" +
                "Explanation: The concurrent executable unit is called a thread. It's performs some background functionalities with services.")
        val quiz11 = Quiz(11L,"11) What is correct way to create an arraylist in Kotlin?","A. val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")", "B. enum class Color {RED, GREEN, BLUE}","C. val list = arrayListOf(1, 2, 3)","D. val set = hashSetOf(1, 2, 3)","c","Answer: (c)  val list = arrayListOf(1, 2, 3)\n" +
                "\n" +
                "Explanation: val list = arrayListOf(1, 2, 3) is correct way to create an arraylist in Kotlin.")
        val quiz12 = Quiz(12L,"12) Which of following targets currently not supported by Kotlin?","A. LLVM", "B. .NET CLR","C. Javascript","D. Neither (a) nor (b)","b","Answer: (b) .NET CLR\n" +
                "\n" +
                "Explanation: .NET CLR is not supported by Kotlin.")
        val quiz13 = Quiz(13L,"13) How do you get the length of a string in Kotlin?","A. str.length", "B. length(str)","C. str.lengthOf","D. len(str)","a","Answer: (a) str.length\n" +
                "\n" +
                "Explanation: str.length is used to get the length of a string in Kotlin")
        val quiz14 = Quiz(14L,"14) Which of the followings constructors are available in Kotlin?",
            "A. Primary constructor", "B. Secondary constructor","C. Both 1 & 2","D. All of the above","c","Answer: (c) Both 1 & 2\n" +
                    "\n" +
                    "Explanation: Both 1 & 2")
        val quiz15 = Quiz(15L,"15) Kotlin is developed by?","A. Google", "B. JetBrains","C. Microsoft","D. Adobe","b","Answer: (b) JetBrains\n" +
                "\n" +
                "Explanation: Kotlin is developed by JetBrains.")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                    quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}