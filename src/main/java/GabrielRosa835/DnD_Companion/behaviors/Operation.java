<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/Operation.java
package GabrielRosa835.dnd_companion.app.tactics;
========
package behaviors;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/Operation.java

@FunctionalInterface
public interface Operation<ReturnType>
{
	ReturnType execute();
}
