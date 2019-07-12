import { Injectable } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(public dialog: MatDialog) { }

  openConfirmDialog(msg: string): Observable<any> {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '350px',
      data: msg
    });
    return dialogRef.afterClosed();
  }
}