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
