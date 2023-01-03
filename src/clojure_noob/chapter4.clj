(ns clojure-noob.chapter4)
;;chapter 4
;;exercise one
;;Turn the result of your glitter filter into a list of names.
(defn names_list
  [list-of-maps]
  (map #(:name %)
       list-of-maps
       ))
;;test it
(def list-of-maps '({:name "Edward Cullen", :glitter-index 10}
 {:name "Jacob Black", :glitter-index 3}
                    {:name "Carlisle Cullen", :glitter-index 6}))
(names_list list-of-maps)
;;exercise two
(defn append
  [current-suspects new-suspect]
  (conj current-suspects new-suspect))
;;exercise three
(defn validate
  [entry]
  (and (contains? entry :name) (contains? entry :glitter-index)))
;;exrcise four
;;Write a function that will take your list of maps and convert it back to a CSV string. You’ll need to use the clojure.string/join function.
(defn from-hash-map-to-array
  [our-hash-map]
  (vector (:name our-hash-map) (:glitter-index our-hash-map)))
;;(from-hash-map-to-array {:name "ali" :glitter-index 10 })
(defn from-list-to-string
  [list-of-maps]
  (def list-of-vectors (map from-hash-map-to-array list-of-maps) )
   (def list-of-suspects (map #(clojure.string/join "," %) list-of-vectors ))
    (clojure.string/join "\n" list-of-suspects)
  
)
;;test
;;(clojure.string/join ", " ["ali" "solh"])
(from-list-to-string list-of-maps)

