;Autor: Hector Rafael Alvarez Aceves
;Matricula: A01632621

(ns resaltador3.0final
  (:gen-class))

;En estas primeras lineas de codigo se defienen los distintos simbolos que serviran para que se reconozcan varios simbolos en el automata
(def espParen '(\space \)))

(def espParenLetNum '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \space \) \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z))

(def digito '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9))

(def delimitador '(\) \space \] \, \* \: \? \!))

(def delimitadorOp '(\space \) \] \+ \* \, \:))

(def espMayor '(\space \>))

(def espIgual '(\space \=))

(def letraGuion '(\_ \A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z))

(def letDigGuiComi '(\A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \_ \'))

(def Es '(\E \e))

(def todosExcComillas '(\< \> \+ \* \/ \' \# \% \: \( \) \space \] \[ \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \, \. \- \= \¨ \[ \] \{ \} \~ \! \¡ \¿ \? \$ \& \| \° \¬ \^ \` \_ \\))

(def todosExcComi '(\A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \< \> \+ \* \/ \" \# \% \: \( \) \space \] \[ \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \, \. \- \= \¨ \[ \] \{ \} \~ \! \¡ \¿ \? \$ \& \| \° \¬ \^ \` \_ \\))

(def todos '(\A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \< \> \+ \* \/ \' \# \% \: \( \) \space \] \[ \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \, \. \- \= \¨ \  \[ \] \{ \} \~ \! \¡ \¿ \? \" \$ \& \| \° \¬ \^ \` \_ \\ \; \‘ \’))

(def todosExcGuiLla '(\newline \A \B \C \D \E \F \G \H \I \J \K \L \M \N \Ñ \O \P \Q \R \S \T \U \W \V \X \Y \Z \a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \< \> \+ \* \/ \' \# \% \: \( \) \space \] \[ \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \, \. \= \¨ \  \[ \] \{ \~ \! \¡ \¿ \? \" \$ \& \| \° \¬ \^ \` \_ \\))

(def simbolos-delimitadores '(\( \) \[ \] \}))

(def comEspCor '(\, \space \]))

(def parenCorchLet '(\a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z \[ \] \( \)))

(def simbEspeciales '(\? \. \, \; \@ \# \$))

(def signos '(\+ \-))

(def letMin '(\a \b \c \d \e \f \g \h \i \j \k \l \m \n \ñ \o \p \q \r \s \t \u \v \w \x \y \z))

(def automata (concat (list (list 0 \space 0)) (list (list 0 \\ 45)) (list (list 0 digito 1)) (list (list 0 \- 7)) (list (list 0 letraGuion 8)) (list (list 0 \{ 39)) (list (list 0 \" 10)) (list (list 0 simbolos-delimitadores 104)) (list (list 0 \' 16)) (list (list 0 \: 36)) (list (list 0 simbEspeciales 111)) (list (list 0 \\ 111)) (list (list 0 \& 34)) (list (list 0 \< 32)) (list (list 0 \newline 112)) (list (list 0 \> 31)) (list (list 0 \= 27)) (list (list 0 \! 30)) (list (list 0 \% 109)) (list (list 0 \* 24)) (list (list 0 \+ 23)) (list (list 0 \/ 26)) (list (list 0 \| 35)) (list (list 1 digito 1)) (list (list 1 Es 11)) (list (list 1 delimitadorOp 100)) (list (list 1 \. 2)) (list (list 2 digito 3)) (list (list 2 \. 14)) (list (list 3 digito 3)) (list (list 3 delimitador 101)) (list (list 3 Es 4)) (list (list 4 digito 6)) (list (list 4 signos 5)) (list (list 5 digito 6)) (list (list 6 digito 6)) (list (list 6 delimitador 101)) (list (list 7 delimitador 105)) (list (list 7 digito 1)) (list (list 7 \- 18)) (list (list 7 \> 111)) (list (list 8 letDigGuiComi 8)) (list (list 8 delimitador 102)) (list (list 10 todosExcComillas 10)) (list (list 10 \" 106)) (list (list 11 signos 12)) (list (list 11 digito 13)) (list (list 12 digito 13)) (list (list 13 digito 13)) (list (list 13 delimitador 100)) (list (list 14 digito 15)) (list (list 14 \] 107)) (list (list 15 digito 15)) (list (list 15 \] 107)) (list (list 16 todosExcComi 17)) (list (list 17 \' 19)) (list (list 17 todosExcComi 20)) (list (list 18 todos 38)) (list (list 19 comEspCor 108)) (list (list 19 \. 21)) (list (list 20 todosExcComi 20)) (list (list 20 \' 107)) (list (list 21 \. 22)) (list (list 22 \' 43)) (list (list 23 \+ 25)) (list (list 23 espParen 105)) (list (list 24 \* 25)) (list (list 24 espParenLetNum 105)) (list (list 25 \space 109)) (list (list 26 \space 105)) (list (list 26 \= 29)) (list (list 27 espMayor 109)) (list (list 27 \= 28)) (list (list 28 espParen 110)) (list (list 29 espParen 110)) (list (list 30 \! 109)) (list (list 31 espIgual 110)) (list (list 32 \space 110)) (list (list 32 \= 33)) (list (list 32 \- 111)) (list (list 33 \space 110)) (list (list 34 \& 110)) (list (list 35 \| 110)) (list (list 35 \space 111)) (list (list 36 parenCorchLet 111)) (list (list 36 \: 37)) (list (list 37 \space 111)) (list (list 38 todos 38)) (list (list 38 \newline 103)) (list (list 39 \- 40)) (list (list 39 \space 104)) (list (list 40 todosExcGuiLla 41)) (list (list 41 todosExcGuiLla 41)) (list (list 41 \- 42)) (list (list 42 \} 103)) (list (list 43 todosExcComi 44)) (list (list 44 \' 107)) (list (list 45 letMin 111))))

(def lista-caracteres-temp '())

(def lista-strings-html '())

;Se define una lista con las palabras reservadas del lenguaje Haskell
(def lista-palabras-reservadas '("last" "init" "tail" "head" "not" "True" "False" "case" "class" "data" "default" "deriving" "do" "else" "if" "import" "in" "infix" "infixl" "infixr" "instance" "let" "module" "newtype" "of" "then" "type" "where" "_"))


;Esta funcion escribe al archivo de salida lo que esta en la lista
;lista-strings-html que contiene el codigo de Haskell
;escrito en codigo en HTML
(defn escribe-a-HTML [lista-strings nombreArch]
  (cond (= () lista-strings) (do (def lista-strings-html '()) true)
        :else (do (cond (= nombreArch "/Users/halvarez/Downloads/prueba1.txt") (spit "/Users/halvarez/Downloads/prueba1.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba2.txt") (spit "/Users/halvarez/Downloads/prueba2.html" (first lista-strings) :append true)  ;:append true (despues del parentesis rojo)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba3.txt") (spit "/Users/halvarez/Downloads/prueba3.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba4.txt") (spit "/Users/halvarez/Downloads/prueba4.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba5.txt") (spit "/Users/halvarez/Downloads/prueba5.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba6.txt") (spit "/Users/halvarez/Downloads/prueba6.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba7.txt") (spit "/Users/halvarez/Downloads/prueba7.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba8.txt") (spit "/Users/halvarez/Downloads/prueba8.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba9.txt") (spit "/Users/halvarez/Downloads/prueba9.html" (first lista-strings) :append true)
                                                (= nombreArch "/Users/halvarez/Downloads/prueba10.txt") (spit "/Users/halvarez/Downloads/prueba10.html" (first lista-strings) :append true) :else 'error) (escribe-a-HTML (rest lista-strings) nombreArch))))


;Se crea una lista que contiene unicamente los estados iniciales del estado actual, es decir si se tiene un estado
;cero, suponiendo que se tiene una lista asi: '((0 a 1) (1 i 2) (0 k 1)) entonces se procede a convertir
;esta lista a lo siguiente: '((0 a 1) (0 k 1))
(defn crear-sublista [edoact transiciones]
  (cond (= () transiciones) '()
        (= edoact (first (first transiciones))) (cons (first transiciones) (crear-sublista edoact (rest transiciones)))
        :else (crear-sublista edoact (rest transiciones))))

;Funcion que busca si un simbolo esta en una lista que corresponde a un simbolo que esta
;en el automata, por ejemplo esta lista podria parecerse a esto: '(0 digito 1)
;si el simbolo corresponde a un simbolo que se encuentra en dicha lista (lista-simb)
;entonces se regresa un true, en caso de que no se regresa un false
(defn encuentra-simbolo [simb lista-simb]
  (cond (= () lista-simb) false
        (= (first lista-simb) simb) true
        :else (encuentra-simbolo simb (rest lista-simb))))


;Funcion que checa si el simbolo identificado convertido a string coincide con alguna
;palabra reservada de la lista llamada lista-palabras-reservadas
(defn chequeo-reservada [simb lista-reservada]
  (cond (= () lista-reservada) false
        (= (first lista-reservada) simb) true
        :else (chequeo-reservada simb (rest lista-reservada))))






;Esta funcion va agregandole a la lista lista-strings-html las lineas de codigo ya convertidas a html
(defn creaListaHTML [simbolo estAcept]
  (cond (or (and (= estAcept 100) (= simbolo \))) (and (= estAcept 100) (= simbolo \])))
        (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
            (def lista-strings-html (concat lista-strings-html
                                            (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (or (and (= estAcept 100) (= simbolo \+)) (and (= estAcept 100) (= simbolo \*)))
        (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
            (def lista-strings-html (concat lista-strings-html
                                            (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (or (and (= estAcept 100) (= simbolo \,)) (and (= estAcept 100) (= simbolo \:))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 100) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) (list \& \n \b \s \p \space)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))


        (or (and (= estAcept 101) (= simbolo \))) (and (= estAcept 101) (= simbolo \])))
        (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \s \l \a \t \e \b \l \u \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
            (def lista-strings-html (concat lista-strings-html
                                            (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))


        (= estAcept 101) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \s \l \a \t \e \b \l \u \e \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))


        (or (and (= estAcept 102) (= simbolo \))) (and (= estAcept 102) (= simbolo \])))
        (cond (chequeo-reservada (clojure.string/replace (apply str lista-caracteres-temp) #"&nbsp " "") lista-palabras-reservadas) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \c \h \i \d \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                                                  (def lista-strings-html (concat lista-strings-html
                                                                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))



              :else (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                        (def lista-strings-html (concat lista-strings-html
                                                        (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '())))
        
        
        (and (= estAcept 102) (= simbolo \*)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))
        
        (or (and (= estAcept 102) (= simbolo \,)) (and (= estAcept 102) (= simbolo \:))) (cond (chequeo-reservada (clojure.string/replace (apply str lista-caracteres-temp) #"," "") lista-palabras-reservadas)
                                                    (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \c \h \i \d \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                        (def lista-strings-html (concat lista-strings-html
                                                                                        (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))



                                                    :else (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                              (def lista-strings-html (concat lista-strings-html
                                                                                              (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '())))
        
        (or (and (= estAcept 102) (= simbolo \?)) (and (= estAcept 102) (= simbolo \!))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \r \e \d \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                                         (def lista-strings-html (concat lista-strings-html
                                                                         (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '())) 


        (= estAcept 102) (cond (chequeo-reservada (clojure.string/replace (apply str lista-caracteres-temp) #"&nbsp " "") lista-palabras-reservadas)
                               (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \c \h \i \d \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) (list \& \n \b \s \p \space)))
                                   (def lista-strings-html (concat lista-strings-html
                                                                   (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))



                               :else (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) (list \& \n \b \s \p \space)))
                                         (def lista-strings-html (concat lista-strings-html
                                                                         (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '())))

        (= estAcept 103) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \r \a \y \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>))) (def lista-strings-html (concat lista-strings-html
                                                                                                                                                                                                                                                (list (apply str lista-caracteres-temp)) (list "<br>"))) (def lista-caracteres-temp '()))



        (and (= estAcept 104) (= simbolo \space)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                                                      (def lista-strings-html (concat lista-strings-html
                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 104) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))



        (or (and (= estAcept 105) (= simbolo \))) (and (= estAcept 105) (= simbolo \]))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                                             (def lista-strings-html (concat lista-strings-html
                                                                                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 105) (encuentra-simbolo simbolo letMin)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                      (def lista-strings-html (concat lista-strings-html
                                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))



        (and (= estAcept 105) (= simbolo \space)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                                                      (def lista-strings-html (concat lista-strings-html
                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))
        
        (= estAcept 105) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \m \e \d \i \u \m \t \u \r \q \u \o \i \s \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \d \a \r \k \g \r \e \e \n \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))





        (= estAcept 106) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \s \a \d \d \l \e \b \r \o \w \n \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))


        (and (= estAcept 107) (= simbolo \])) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \r \e \d \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 107) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \r \e \d \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 108) (= simbolo \,)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))
        
        (and (= estAcept 108) (= simbolo \])) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \r \e \e \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 108) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \r \e \e \n \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>) ))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (or (and (= estAcept 109) (= simbolo \%)) (and (= estAcept 109) (= simbolo \!)) (and (= estAcept 109) (= simbolo \>))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \p \u \r \p \l \e \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                                                                                   (def lista-strings-html (concat lista-strings-html
                                                                                                                                                                   (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 109) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \p \u \r \p \l \e \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 110) (= simbolo \))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \a \n \g \e \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                  (def lista-strings-html (concat lista-strings-html
                                                                                  (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 110) (= simbolo \space)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \a \n \g \e \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                                                      (def lista-strings-html (concat lista-strings-html
                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))


        (= estAcept 110) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \o \r \a \n \g \e \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (or (and (= estAcept 111) (= simbolo \))) (and (= estAcept 111) (= simbolo \]))) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \o \l \d \e \n \r \o \d \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                                             (def lista-strings-html (concat lista-strings-html
                                                                                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 111) (encuentra-simbolo simbolo letMin)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) lista-caracteres-temp '(\< \/ \s \p \a \n \>) '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \b \l \u \e \' \>) (list simbolo) '(\< \/ \s \p \a \n \>)))
                                                                      (def lista-strings-html (concat lista-strings-html
                                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (and (= estAcept 111) (= simbolo \space)) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) lista-caracteres-temp (list \& \n \b \s \p \space) '(\< \/ \s \p \a \n \>)))
                                                      (def lista-strings-html (concat lista-strings-html
                                                                                      (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 111) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \c \y \a \n \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>)))
                             (def lista-strings-html (concat lista-strings-html
                                                             (list (apply str lista-caracteres-temp)))) (def lista-caracteres-temp '()))

        (= estAcept 112) (do (def lista-caracteres-temp '()) (def lista-strings-html (concat lista-strings-html (list "<br>"))))

        :else 'errorCrearListaHTML))


;En esta funcion si el simbolo recibido es igual al simbolo que
;se encuentra en la lista lista-simb, entonces se regresara el estado
;siguiente
(defn busca-simbolo [simbolo paresT]
  (cond (= () paresT) 'errorBuscaSimbolo
        ;se verifica si el cadar de paresT es una lista, si lo es se llama a encuentra-simbolo para que
        ;encuentre el simbolo en la lista del cadar de paresT, en caso de que lo encuentre
        ;se verifica si es que el siguiente estado es un estado aceptor y si lo es se llama a crearListaHTML y se regresa un cero
        ;que es el estado cero
        (and (seq? (first (rest (first paresT)))) (encuentra-simbolo simbolo (first (rest (first paresT))))) (if (or (= (first (rest (rest (first paresT)))) 100) (= (first (rest (rest (first paresT)))) 101) (= (first (rest (rest (first paresT)))) 102) (= (first (rest (rest (first paresT)))) 103) (= (first (rest (rest (first paresT)))) 104) (= (first (rest (rest (first paresT)))) 105) (= (first (rest (rest (first paresT)))) 106) (= (first (rest (rest (first paresT)))) 107) (= (first (rest (rest (first paresT)))) 108) (= (first (rest (rest (first paresT)))) 109) (= (first (rest (rest (first paresT)))) 110) (= (first (rest (rest (first paresT)))) 111) (= (first (rest (rest (first paresT)))) 112)) (do (creaListaHTML simbolo (first (rest (rest (first paresT))))) 0) (do (if (= simbolo \newline) (do (def lista-caracteres-temp (concat '(\< \s \p \a \n \space \s \t \y \l \e \= \space \' \c \o \l \o \r \: \space \g \r \a \y \' \>) lista-caracteres-temp (list simbolo) '(\< \/ \s \p \a \n \>))) (def lista-strings-html (concat lista-strings-html
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       (list (apply str lista-caracteres-temp)) (list "<br>"))) (def lista-caracteres-temp '())) (def lista-caracteres-temp (concat lista-caracteres-temp (if (= simbolo \space) (list \& \n \b \s \p \space) (if (= simbolo \return) '() (list simbolo)))))) (first (rest (rest (first paresT))))))    ;en caso de que no sea un estado aceptor, se agrega a la lista lista-caracteres-temp el simbolo identificado y se regresa al siguiente estado

        ;si es que el simbolo es igual al simbolo de cadar de paresT se verifica si el caddar de paresT es un estado aceptor,
        ;si lo es se llama a CrearListaHTML y se regresa un cero que es el estado cero
        (= simbolo (first (rest (first paresT)))) (if (or (= (first (rest (rest (first paresT)))) 100) (= (first (rest (rest (first paresT)))) 101) (= (first (rest (rest (first paresT)))) 102) (= (first (rest (rest (first paresT)))) 103) (= (first (rest (rest (first paresT)))) 104) (= (first (rest (rest (first paresT)))) 105) (= (first (rest (rest (first paresT)))) 106) (= (first (rest (rest (first paresT)))) 107) (= (first (rest (rest (first paresT)))) 108) (= (first (rest (rest (first paresT)))) 109) (= (first (rest (rest (first paresT)))) 110) (= (first (rest (rest (first paresT)))) 111) (= (first (rest (rest (first paresT)))) 112)) (do (creaListaHTML simbolo (first (rest (rest (first paresT))))) 0) (do (def lista-caracteres-temp (concat lista-caracteres-temp (if (= simbolo \space) (list \& \n \b \s \p \space) (if (= simbolo \return) '() (list simbolo))))) (first (rest (rest (first paresT))))))  ;se verifica si hay un espacio y si lo hay se agrega el comando de espacio para html &nbsp

        :else (busca-simbolo simbolo (rest paresT))))

;regresa el siguiente estado en baso al simbolo actual, el estado actual y el automata
(defn sig-edo [edoact simbolo transiciones]
  (cond (= () transiciones) 'errorSig-Edo
        (= edoact (first (first transiciones)))  (busca-simbolo simbolo (crear-sublista edoact transiciones))
        :else (sig-edo edoact simbolo (rest transiciones))))

;Funcion auxiliar que recibe el estado actual, recibe el automata y la secuencia a reconocer por el automata
;esta funcion practicamente ayuda a reconocer los caracteres que se encuentran en una lista
;y una vez que dicha lista llega a su fin se regresa el ultimo estado al que se llego con el lexico
;reconocido por el automata
(defn aceptaAux [estadoAct automata secuencia]
  (if (= () secuencia)
    estadoAct
    (aceptaAux (sig-edo estadoAct (first secuencia) automata) automata (rest secuencia))))

;Funcion que recibe al autmomata y tambien cada linea del archivo que tiene
;el codigo en Haskell
(defn acepta? [automata secuencia nombreArch]
  ;Esta verificacion unicamente sirve para cuando se acabe de checar todos los caracteres en el archivo, se mande al
  ;archivo .html el codigo resaltado
  (if (not (seq? (aceptaAux 0 automata secuencia))) (escribe-a-HTML lista-strings-html nombreArch) 'error))




;Funcion que va pasando cada sublista en la lista lista-caracteres a la funcion;
;acepta? automata y cuando detecte que se ha llegado al final de la lista lista-caracteres
;se procedera a cerrar el output-port
(defn procesa-lista-caracteres [automata lista-caracteres nombreArch]
  (cond (= () lista-caracteres) (println "Codigo resaltado con exito")
        :else (acepta? automata lista-caracteres nombreArch)))

;Se leen todas las linea del archivo "nombresArchivos.txt que contiene en cada linea los nombres y direcciones de los archivos a leer"
(use 'clojure.java.io)
(def nombArch (with-open [rdr (clojure.java.io/reader "/Users/halvarez/Downloads/nombresArchivos.txt")] (reduce conj [] (line-seq rdr))))

;Se hace el resaltado de la sintaxis de Haskell de manera secuencial a varios archivos, en este caso del proyecto se haran de 10 archivos y tambien se toma el tiempo que tarda esta operacion
(time (doall (map #(procesa-lista-caracteres automata  (seq (char-array (slurp %))) %) nombArch)))

;Se hace el resaltado de la sintaxis de Haskell de manera paralela y se toma el tiempo que tarda esta operacion (esta linea de codigo no es funcional)
(time (doall (pmap #(procesa-lista-caracteres automata  (seq (char-array (slurp %))) %) nombArch)))