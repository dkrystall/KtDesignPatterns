package cs4540.observerPattern

/**
 * KtDesignPatterns
 * @author David Krystall
 * ret
 * 9/14/19
 */

//The thing being observed, will have many observers.
interface Subject {
    fun addObserver(observer: Observer){}
    fun removeObserver(observer: Observer){}
    fun notifyObservers(){}
}