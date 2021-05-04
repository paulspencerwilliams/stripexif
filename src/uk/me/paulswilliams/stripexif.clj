(ns uk.me.paulswilliams.stripexif
  (:require [clojure.java.shell :refer [sh]])
  (:gen-class))

(defn strip-tags-from-file [path filename]
  (sh "bash" "-c" (str "$PWD/strip-tags.sh" " " path " '" filename "'")))

(defn strip-tags-from-files [path]
  (->>
    (file-seq (clojure.java.io/file path))
    (filter
      (fn [n]
        (and
          (.isFile n)
          (re-matches #".*.jpg" (.getName n)))))
    (map
      (fn [f]
        {:filename (.getName f)
         :result   (strip-tags-from-file path (.getName f))}))))

(defn -main
  "Orchestrate stripping tags and publishing photos in the specified folder"
  [& args]
  (println (strip-tags-from-files (first args))))
