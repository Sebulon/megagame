import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TextFormatService {

  constructor() {
  }

  convertFromMarkdownToHtml(text: string) {
    return text.replace(/\.[s]*/g, ". ")
      .replace(/\*\*/g, "<b>")
      .replace(/<b>([^|]*)<b>/g, "<b>$1</b>")
  }
}
