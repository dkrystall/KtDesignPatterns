package cs4540.observerPattern

/**
 *  Concrete Observer class, used to subscribe to Subject
 *  @property subject the Observable Object that this subscribes to.
 *  @property name the name of the Subscriber
 */

class Subscriber(subject: Subject, name: String?): Observer {
    private var subject:Subject
    var name:String?
    init {
        this.subject = subject
        this.name = name
    }
    init {
        this.subject = subject
    }

    fun subscribe(){
        this.subject.addObserver(this)
        println("$name has subscribed!")
    }

    fun unsubscribe(){
        this.subject.removeObserver(this)
        println("$name has un-subscribed :(")
    }


    private fun printNewsletter(newsletter: String){
        println(newsletter)
    }

    /**
     * This function is called from the Subject this is subscribed to.
     */
    override fun update(){
        if(this.subject is NewsLetterPublisher){
            printNewsletter(NewsLetterPublisher.newsletter)
        }
    }
}