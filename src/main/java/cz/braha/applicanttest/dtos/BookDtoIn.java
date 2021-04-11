package cz.braha.applicanttest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDtoIn {


	public String isbn;
	public String name;
	public int id;

	public Set<Integer> genres;
}
