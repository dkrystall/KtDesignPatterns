package cs4540.observerPattern

/**
 * KtDesignPatterns
 * @author David Krystall
 * ret
 * 9/14/19
 */

//The thing being observed, will have many observers.
interface Subject<T, S> {
    fun addObserver(observer: T)
    fun removeObserver(observer: T)
    fun notifyObservers()
    fun setState(state: S)
}