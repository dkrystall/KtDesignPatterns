package cs4540.observerPattern

/**
 * @property subscribers List of Observers listening to this Subject
 */
object NewsLetterPublisher: Subject {
    private val subscribers = mutableListOf(Subscriber(NewsLetterPublisher, null))
    lateinit var newsletter:String

    init{
        subscribers.removeAt(0) //setting the list type puts a null Subscriber in it
    }

    override fun addObserver(observer: Observer) {
        super.addObserver(observer)
        if(observer is Subscriber) {
            subscribers.add(observer)
        }
    }

    override fun removeObserver(observer: Observer) {
        super.removeObserver(observer)
        subscribers.remove(observer)
    }

    /**
     * This calls the update function in all the Observers
     */
    override fun notifyObservers() {
        super.notifyObservers()
        for(subscriber in subscribers) {
            subscriber.update()
        }
    }

    fun publishNewsletter(newsletter: String){
        this.newsletter = newsletter
        notifyObservers()
    }
}
