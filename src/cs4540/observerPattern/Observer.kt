package cs4540.observerPattern

//The thing that wants to know about the subject, and wants updates
interface Observer {
    fun update(){
        //this gets called by the subject
    }
}