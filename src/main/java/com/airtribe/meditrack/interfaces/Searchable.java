package main.java.com.airtribe.meditrack.interfaces;

import java.util.List;

public interface Searchable<T,C>{

    List<T> search(List<T> list, C criteria);

}