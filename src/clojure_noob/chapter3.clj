(ns clojure-noob.chapter3)
;;chapter 3
;;exercise one ok
;; exercise two
(defn add_100
  "this function add 100 to the passsed number"
  [number]
  (+ number 100))
;;test it
(add_100 10)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;Exercise 3
(defn decmaker
  "This function will make a dec function by value passed"
  [dec_value]
  #(- % dec_value))
;;test it
(def dec9 (decmaker 9))
(dec9 10)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;exercise 4
(defn mapset
  "this function will take a function and vector and will map the function to each element in the vector and return the result as list"
  [function collection]
  (set (map function collection)))
;;test it
(mapset inc [1 1 2 2])
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;exercise 5
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])
(defn matching-part
  [part]
  (map (fn [number] {:name (clojure.string/replace (:name part) #"^left-" number) :size (:size part)})
       ["1st-" "2nd-" "3rd-" "4th-" "5th-"]))
;; (matching-part {:name "head" :size 3})
;; (matching-part {:name "left-eye" :size 3})
(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-part part))))
          []
          asym-body-parts))
;;test it
(symmetrize-body-parts asym-hobbit-body-parts)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;exercise 6
(defn generate_array [n]
  (into [] (range 1 (+ n 1))))

;;(generate_array 5)
(defn matching-part-two
  [part n]
  (map (fn [number] {:name (clojure.string/replace (:name part) #"^left-" (str number "-")) :size (:size part)})
       (generate_array n)))
(matching-part-two {:name "left-ear" :size 1} 2)

(defn symmetrize-body-parts-generalized
  "Expects a seq of maps that have a :name and :size and nuber of occurences"
  [asym-body-parts n]
  (println asym-body-parts)
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (matching-part-two part n))))
          []
          asym-body-parts))
;;test
(symmetrize-body-parts-generalized asym-hobbit-body-parts 2)