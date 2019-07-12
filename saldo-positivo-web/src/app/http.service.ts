import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

const options = {
  headers:{
    "Content-Type": "application/json"
  }
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) { }

  get(service: string): Observable<any>{
    return this.http.get(environment.serviceApi+service);
  }
  post(service:string, body: any): Observable<any>{
    return this.http.post(environment.serviceApi+service,body,options);
  }
  put(service:string,body: any): Observable<any>{
    return this.http.put(environment.serviceApi+service, body,options);
  }
  delete(service:string,id: string): Observable<any>{
    return this.http.delete(environment.serviceApi+service+"/"+id);
  }
}
