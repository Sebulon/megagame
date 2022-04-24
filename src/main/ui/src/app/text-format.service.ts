import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TextFormatService {

  constructor() {
  }

  convertFromMarkdownToHtml(text: string) {
    return text
      .replace(/\\/gm, "<br>") // Convert break lines
      .replace(/\*\*([^*]*)\*\*/gm, "<strong>$1</strong>") // Convert bold
  }
}
