package cs4540.observerPattern

//The thing being observed, will have many observers.
interface Subject {
    fun addObserver(observer: Observer){}
    fun removeObserver(observer: Observer){}
    fun notifyObservers(){}
}