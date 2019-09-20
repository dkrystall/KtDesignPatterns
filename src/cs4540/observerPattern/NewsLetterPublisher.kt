package cs4540.observerPattern

/**
 * KtDesignPatterns
 * @author David Krystall
 * ret
 * 9/14/19
 */

/**
 * @property subscribers List of Observers listening to this Subject
 */

object NewsLetterPublisher: Subject<Observer<String>,Int> {
    private val subscribers = mutableListOf<Observer<String>>()
    private var newsletter:String? = null
    private var x:Int = 0

    override fun addObserver(observer: Observer<String>) {
        subscribers.add(observer)
    }

    override fun removeObserver(observer: Observer<String>) {
        subscribers.remove(observer)
    }

    /**
     * This calls the update function in all the Observers
     */
    override fun notifyObservers() {
        subscribers.forEach{ this.newsletter?.let { newsletter -> it.update(newsletter) } }
    }

    fun publishNewsletter(newsletter: String = "Exciting news! We have raised $x million dollars!"){
        this.newsletter = newsletter
        notifyObservers()
    }

    /**
     * Sets the dollar value for this publisher's newsletter
     */
    override fun setState(state: Int){
        this.x = state
    }
}