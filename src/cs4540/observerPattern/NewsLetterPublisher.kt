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

object NewsLetterPublisher: Subject {
    private val subscribers = mutableListOf<Observer>()
    private var newsletter:String? = null

    override fun addObserver(observer: Observer) {
        super.addObserver(observer)
        subscribers.add(observer)
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
        subscribers.forEach{ this.newsletter?.let { it1 -> it.update(it1) } }
    }

    fun publishNewsletter(newsletter: String?){
        this.newsletter = newsletter
        notifyObservers()
    }
}