import java.util.*;
class Movie{
    String title;
    String director;
    int year;
    int rating;
    Movie prev;
    Movie next;
    Movie(String title,String director,int year,int rating){
        this.title=title;
        this.director=director;
        this.year=year;
        this.rating=rating;
        this.prev=null;
        this.next=null;

    }
}
class MovieList{
    private Movie head;
    private Movie tail;
    public void addAtbeginning(String title,String director,int year,int rating){
        Movie newMovie=new Movie(title,director,year,rating);
            if(head==null){
                head=tail=newMovie;
                return;
            }
            newMovie.next=head;
            head.prev=newMovie;
            head=newMovie;
    }
    public void addAtend(String title,String director,int year,int rating){
                Movie newMovie=new Movie(title,director,year,rating);
                if(head==null){
                    head=tail=newMovie;
                    return;
                }
                 tail.next=newMovie;
                 newMovie.prev=tail;
                 tail=newMovie;          
    }
    public void addAtPosition(String title,String director,int year,int rating,int position){
        Movie newMovie=new Movie(title,director,year,rating,position){
            if(position==1){
                head=tail=newMovie;
                return;
            }
            Movie temp=head;
            for(int i=1;temp!=null && i<position-1;i++){
                temp=temp.next;
            }
            newMovie.next=temp.next;
            newMovie.prev=temp;
            if(temp.next!=null){
                temp.next.prev=newMovie;
            }
            else{
                tail=newMovie;
            }
            temp.next=newMovie;
        }
    }
}