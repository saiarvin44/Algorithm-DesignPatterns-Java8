package BestPractices.BestAccessLevelPattern;

import java.util.Objects;

public final class ImmutableClassPattern {
  private final double im;
  private final double re;

  public ImmutableClassPattern(double im, double re) {
    this.im = im;
    this.re = re;
  }

  public double getIm() {
    return im;
  }

  public double getRe() {
    return re;
  }

  public ImmutableClassPattern plus(ImmutableClassPattern c) {
    return new ImmutableClassPattern(re + c.re, im + c.im);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ImmutableClassPattern that = (ImmutableClassPattern) o;
    return Double.compare(that.im, im) == 0 && Double.compare(that.re, re) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(im, re);
  }
}
