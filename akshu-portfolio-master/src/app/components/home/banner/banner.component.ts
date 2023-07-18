import { Component, OnInit } from '@angular/core';
import { trigger, state, style, animate, transition, stagger, query } from '@angular/animations';
import { AnalyticsService } from 'src/app/services/analytics/analytics.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss'],
  animations: [
    trigger('bannerTrigger', [
      transition(':enter', [
        query('*', [
          style({ opacity: 0, transform: 'translateX(-50px)' }),
          stagger(50, [
            animate(
              '250ms cubic-bezier(0.35, 0, 0.25, 1)',
              style({ opacity: 1, transform: 'none' })
            )
          ])
        ])
      ])
    ])
  ]
})
export class BannerComponent implements OnInit {

  bannerDescription: string;

  constructor(
    public analyticsService: AnalyticsService,
    private translateService: TranslateService
  ) { }

  ngOnInit(): void {
    const sentence = `I am interested in gaining industry experience in the field of software engineering, particularly more into the development aspect. An PG course with experience in technical projects. Seeking to learn and render quality service to the organization by progressing both individually and professionally.`;
    this.bannerDescription = this.translateService.instant(sentence);
  }
}
