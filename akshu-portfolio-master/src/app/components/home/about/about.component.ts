import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from 'src/app/services/analytics/analytics.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  translatedParagraphs: string[];

  constructor(
    public analyticsService: AnalyticsService
  ) {
    this.translatedParagraphs = [
      'I am interested in gaining industry experience in the field of software engineering, particularly more into the development aspect.',
      'An PG course with experience in technical projects. Seeking to learn and render quality service to the organization by progressing both individually and professionally.'
    ];
  }

  ngOnInit(): void {
  }
}
