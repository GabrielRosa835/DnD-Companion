package app.rpg.models;

public interface Actor<Element> extends IEntity
{
   void update (Element clone);
}
