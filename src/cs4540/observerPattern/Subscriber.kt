package cs4540.observerPattern

/**
 * KtDesignPatterns
 * @author David Krystall
 * ret
 * 9/14/19
 */

/**
 *  Concrete Observer class, used to subscribe to Subject
 *  @property subject the Observable Object that this subscribes to.
 *  @property name the name of the Subscriber
 */
class Subscriber(private val subject: Subject<Observer<String>>, private val name: String): Observer<String> {

    fun subscribe(){
        this.subject.addObserver(this)
        println("$name has subscribed!")
    }
    fun unsubscribe(){
        this.subject.removeObserver(this)
        println("$name has un-subscribed :(")
    }

    private fun printNewsletter(newsletter: String?){ println(newsletter) }

    /**
     * This function is called from the Subject this is subscribed to.
     */
    override fun update(value: String){
        if(this.subject is NewsLetterPublisher){
            printNewsletter(value)
        }
    }
}