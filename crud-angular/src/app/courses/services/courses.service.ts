import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs/operators';

import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

    private readonly API = 'api/courses';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Course[]>(this.API).pipe(
      first(),
      delay(2000),
      tap(courses => console.log(courses))
    );
  }

  save(record: Partial<Course>){ //Partial<> faz com que se aceite o que se recebe contanto que tenha pelo menos uma característica do objeto. Ex: name, category | e sem _id
    return this.httpClient.post<Course>(this.API, record).pipe(first());
  }
}
