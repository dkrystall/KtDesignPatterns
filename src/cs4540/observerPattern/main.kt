package cs4540.observerPattern

fun main(args: Array<String>) {

    val mike = Subscriber(NewsLetterPublisher, "Mike")
    val kevin = Subscriber(NewsLetterPublisher, "Kevin")
    val esmerelda = Subscriber(NewsLetterPublisher, "Esmerelda")
    val hector = Subscriber(NewsLetterPublisher, "Hector")
    val letty = Subscriber(NewsLetterPublisher, "Letty")
    val observers = arrayOf(mike, kevin, esmerelda, hector, letty)

    for(observer in observers){
        observer.subscribe()
    }

    for (dollars in 1..20) {
        NewsLetterPublisher.publishNewsletter("Exciting news! We have raised $dollars million dollars!")
        when(dollars){
            3 -> {
                mike.unsubscribe()
                esmerelda.unsubscribe()
            }
            10 -> {
                kevin.unsubscribe()
                hector.unsubscribe()
            }
        }
    }
}