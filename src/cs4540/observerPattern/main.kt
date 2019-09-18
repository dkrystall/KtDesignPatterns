package cs4540.observerPattern

/**
 * KtDesignPatterns
 * @author David Krystall
 * ret
 * 9/14/19
 */

fun main(args: Array<String>) {
    val mike = Subscriber(NewsLetterPublisher, "Mike")
    val kevin = Subscriber(NewsLetterPublisher, "Kevin")
    val esmerelda = Subscriber(NewsLetterPublisher, "Esmerelda")
    val hector = Subscriber(NewsLetterPublisher, "Hector")
    val letty = Subscriber(NewsLetterPublisher, "Letty")
    val observers = arrayOf(mike, kevin, esmerelda, hector, letty)
    observers.forEach { it.subscribe() }

    (1..20).forEach {
        NewsLetterPublisher.publishNewsletter("Exciting news! We have raised $it million dollars!")
        when(it){
            3 -> {mike.unsubscribe(); esmerelda.unsubscribe()}
            10 -> {kevin.unsubscribe(); hector.unsubscribe()}
        }
    }
}