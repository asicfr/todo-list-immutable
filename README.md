---------------------------------------------------------------------------------------------------------------------------
-- principals : --


--> immutables objects
		final classes and final private properties
		use guava for immutable collections
		defensive copy for mutable object (date) in getter and constructor
		check immutability at runtime with jcabi aspect @Immutable (see junit test)
			doesn't allow classes to have any non-private, non-final properties in order to be called truly immutable
			a property with a type that is an interface, that child interface has to be annotated with @Immutable
--> avoid null
		manual check input in constructor with guava
		mark object with @Nonull and check code with findbugs
--> maximum quality
		code well commented
		unit tests with well named methods
		java methods well named
		qulice (mvn com.qulice:qulice-maven-plugin:check)

---------------------------------------------------------------------------------------------------------------------------
-- To do : --

* supprimer les getter setter ? -> passer a une programmation plus objet
* composition ???????????
* monad / optional java 8
* qulice
	ne le déclencher qu'avec un profil specifique
* lombok ---> ne permet pas la copie defensive !!!
	mettre les annotations
* nullobject de todo
	le mettre en oeuvre, l'utiliser
* add annotation notnull
	FindBugs et @Nonull
	Checker Framework: nullness (@Nullable), immutability et interning
	http://types.cs.washington.edu/checker-framework/ 
	http://stackoverflow.com/questions/4963300/which-notnull-java-annotation-should-i-use
	http://robaustin.wikidot.com/annotations-and-notnull
	http://findbugs.sourceforge.net/manual/annotations.html
	
		javax.validation.constraints.NotNull
		edu.umd.cs.findbugs.annotations.NonNull
		javax.annotation.Nonnull
		lombok.NonNull


* clean maven pom



---------------------------------------------------------------------------------------------------------------------------
-- Doc : --

http://aspects.jcabi.com/annotation-immutable.html
http://aspects.jcabi.com/example-weaving.html



