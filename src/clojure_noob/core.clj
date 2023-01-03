(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn isEven [num] (= 0 (mod num 2)))
(filter isEven [1 2 3 4 5])

(def sum #(reduce + %))
(def ct #(count %))
(def avg #(/ (sum %) (ct %)))
(defn stats [coll]
  (map #(% coll) [sum ct avg])
  )
(stats [1 2 3 4 5])
(defn testf [new-map [key val]]
  (assoc new-map key (inc val)))
(testf { "ali" 1  "solh" 2} [ "z" 3])
;;map using reduce
(defn mymap [fn coll]
  (seq (reduce #(conj %1 (fn %2)) [] coll)))
(mymap inc [1 2 3 4 5])
(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])
(filter #(< (:month %) 3) food-journal)
(some #(and (= (mod % 2) 0) %) [1 4])
(apply + [1 2 3 4 5])
